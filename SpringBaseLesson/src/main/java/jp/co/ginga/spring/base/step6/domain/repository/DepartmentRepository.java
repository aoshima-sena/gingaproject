package jp.co.ginga.spring.base.step6.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import jp.co.ginga.spring.base.step6.domain.entity.DepartmentEntity;

/**
 * @author someya
 * SQL定義クラス
 */
@Mapper
@Repository
public interface DepartmentRepository {

	@Select("select * from department"
			+ " order by deptno asc")
	@Results({
			@Result(property = "deptno", column = "deptno"),
			@Result(property = "deptname", column = "deptname")
	})
	public List<DepartmentEntity> findAll();
	// 全取得

	@Insert("insert into department ("
			+ " deptname"
			+ ",deptThumbnail"
			+ " ) values ("
			+ " #{deptname}"
			+ ",#{deptThumbnail}"
			+ " )")
	@Options(useGeneratedKeys = true, keyProperty = "deptno")
	public boolean add(DepartmentEntity entity);
	// 登録

	@Update("update department set"
			+ " deptname = #{deptname}"
			+ " where deptno = #{deptno}")
			public boolean update(DepartmentEntity entity);
	// 更新

	@Delete("delete from department where deptno = #{deptno}")
	public boolean delete(Long deptno);
	// 削除

	@Select("select * from department"
	        + " where deptno = #{deptno}")
	@Results({
	        @Result(property = "deptno", column = "deptno"),
	        @Result(property = "deptname", column = "deptname"),
	})
	public DepartmentEntity findOneById(Long deptno);
	// Idを元に検索


	//SQLはxmlにて定義
	public DepartmentEntity selectDeptEmp(Long deptno);





}
