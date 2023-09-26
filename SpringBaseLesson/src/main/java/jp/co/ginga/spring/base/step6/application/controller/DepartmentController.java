package jp.co.ginga.spring.base.step6.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.ginga.spring.base.step6.application.form.DepartmentForm;
import jp.co.ginga.spring.base.step6.application.helper.DepartmentHelper;
import jp.co.ginga.spring.base.step6.domain.entity.DepartmentEntity;
import jp.co.ginga.spring.base.step6.domain.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@Autowired
	DepartmentHelper departmentHelper;

	/**
	* 一覧表示
	* @param model
	* @return
	*/
	@GetMapping(path = "/step6/list")
	public String createList(Model model, Integer page) {

		List<DepartmentEntity> departmentList = departmentService.getDepartmentList();
		model.addAttribute("departmentList", departmentList);

		// ページネーション
		PagedListHolder<DepartmentEntity> pagedListHolder = new PagedListHolder<>(departmentList);
		pagedListHolder.setPageSize(5); // 5件毎に表示
		model.addAttribute("maxPages", pagedListHolder.getPageCount());

		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			page = 1;
		}
		model.addAttribute("page", page);

		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			model.addAttribute("departmentList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			model.addAttribute("departmentList", pagedListHolder.getPageList());
		}

		return "step6/list";
	}

	@GetMapping(path = "/step6/add")
	public String add(@ModelAttribute DepartmentForm form, ModelMap model) {

		form.clear();
		model.addAttribute("departmentForm", form);

		return "step6/add";
	}

	@PostMapping(path = "/step6/add")
	public String addComplete(@ModelAttribute @Validated DepartmentForm form, BindingResult result, Model model)
			throws Exception {

		if (result.hasErrors()) {
			System.out.println("バリデートエラー");
			System.out.println(result);
			return "step6/add";
		}

		//FormをEntityに変換
		DepartmentEntity entity = departmentHelper.convertFromFormToEntity(form);

		//DB登録処理
		int add = departmentService.add(entity);

		if (add == 0) {
			return "redirect:step6/add";
		}

		return "redirect:/step6/list";

	}

	@GetMapping(path = "/step6/edit/{deptno}")
	public String edit(@PathVariable Long deptno, Model model) {

		DepartmentEntity entity = departmentService.getDepartment(deptno);
		model.addAttribute("department", entity);

		return "step6/edit";
	}

	@PostMapping(path = "/step6/edit/{deptno}")
	public String editComplete(@PathVariable Long deptno, Model model, HttpServletRequest request) {

		DepartmentEntity entity = new DepartmentEntity();
		entity.setDeptno(deptno);
		entity.setDeptname(request.getParameter("deptname"));

		int update = departmentService.update(entity);

		if (update == 0) {
			return "redirect:/step6/edit/" + deptno;
		}
		return "redirect:/step6/list";
	}

	// 削除
	@PostMapping(path = "/step6/delete/{deptno}")
	public String delete(@PathVariable Long deptno) {

		departmentService.delete(deptno);
		return "redirect:/step6/list";
	}

	//
	@GetMapping(path = "/step6/detail/{deptno}")
	public String detail(@PathVariable Long deptno, Model model) {
		DepartmentEntity department = departmentService.selectDeptEmp(deptno);
		model.addAttribute("department", department);

		return "step6/detail";
	}
}
