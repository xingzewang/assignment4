package com.xingze.controller;

import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xingze.bean.student;
import com.xingze.utils.MybatisUtils;

@Controller
public class studentController {
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "hello";	
	}
	
	@RequestMapping("/insertStudent")
	public void insertStudent(student s)
	{	
		SqlSession sqlSession=null;
		try{
			sqlSession=MybatisUtils.getSession();
			sqlSession.insert("com.xingze.mapper.studentMapper.insertStudent",s);
			//提交事务，下同
			sqlSession.commit();
		}catch(Exception e)
		{
			//回滚事务，下同
			sqlSession.rollback();
			e.printStackTrace();
			//return "false";
			
		}finally
		{
			if(sqlSession!=null)  {
				sqlSession.close();
			}
		}
		//return "index";
	}

	@RequestMapping(value="/getAllStudent")
	public void getAllStudent() {
		SqlSession sqlSession=null;
		try {
				sqlSession=MybatisUtils.getSession();
				List<student> studentList=new ArrayList<student>();
				studentList=sqlSession.selectList("com.xingze.mapper.studentMapper.getAllStudent");
				sqlSession.commit();
				for(student s : studentList) {
					System.out.println(s);
				}
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@RequestMapping(value="getStudentById")
	public void getStudentById(String id)
	{
		SqlSession sqlSession=null;
		try {
				sqlSession=MybatisUtils.getSession();
				student s=new student();
				s=sqlSession.selectOne("com.xingze.mapper.studentMapper.getStudentById",id);
				sqlSession.commit();
				System.out.println(s);
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@RequestMapping(value="deleteStudentById")
	public void deleteStudentById(String id)
	{
		SqlSession sqlSession=null;
		try {
				sqlSession=MybatisUtils.getSession();
				sqlSession.delete("com.xingze.mapper.studentMapper.deleteStudentById",id);
				sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@RequestMapping(value="updateStudentById")  //修改的逻辑是先查找再修改
	public void updateStudentById(student s)
	{
		SqlSession sqlSession=null;
		try {
				sqlSession=MybatisUtils.getSession();
				//根据传入的student对象id值查询student对象
				student ss=sqlSession.selectOne("com.xingze.mapper.studentMapper.getStudentById",s.getId());
				//根据传入的对象值设置值
				ss.setName(s.getName());
				ss.setPassword(s.getPassword());
				ss.setSex(s.getSex());
				ss.setTelphone(s.getTelphone());
				//执行更新操作
				sqlSession.update("com.xingze.mapper.studentMapper.updateStudentById",ss);
				sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	public static void main(String[] args) {
		studentController s=new studentController();
		student sss=new student("1006","福福","男","436541","4123569");
		s.insertStudent(sss);
		//s.getStudentById("1897456");
		//s.deleteStudentById("1897456");
		//s.getAllStudent();
	}
	
	
}
