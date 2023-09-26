package jp.co.ginga.spring.base.step6.application.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jp.co.ginga.spring.base.step6.application.form.DepartmentForm;
import jp.co.ginga.spring.base.step6.domain.entity.DepartmentEntity;

@Component
public class DepartmentHelper {

	public DepartmentEntity convertFromFormToEntity(DepartmentForm form) throws Exception {

		String file = null;

		if (!form.getDeptThumbnail().getOriginalFilename().isBlank()) {
	        file = this.deptThumbnail(form.getDeptThumbnail());
	    }

		return new DepartmentEntity(
				form.getDeptno(),
				form.getDeptname(),
				file);
	}

	public String deptThumbnail(MultipartFile file) throws Exception {

	    String fileName = UUID.randomUUID().toString() + file.getOriginalFilename(); // UUIDを生成
	    byte[] data = file.getBytes();
	    String filePath = new File("src\\main\\resources\\static\\images").getAbsolutePath() + "\\" + fileName;
	    FileOutputStream fos = new FileOutputStream(filePath);
	    fos.write(data);
	    fos.close();

	    return fileName;

	}

}
