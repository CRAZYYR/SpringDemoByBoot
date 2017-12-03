package com.mylzs.cn.controller;

import com.mylzs.cn.dao.BookDao;
import com.mylzs.cn.entity.Book;
import javafx.beans.property.SetProperty;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 17/12/3.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookDao  bookDao;
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("bookList",   bookDao.findAll());
        modelAndView.setViewName("bookList");
        return modelAndView;
    }

    /**
     * 根据条件动态查询
     * @return
     */
    @RequestMapping("/list2")
    public ModelAndView list2(Book book){
        ModelAndView modelAndView=new ModelAndView();
       List<Book>  bookList=bookDao.findAll(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               Predicate  predicate=  criteriaBuilder.conjunction();
               if (book!=null){
                   if (book.getName()!=null && !"".equals(book.getName())){
                       predicate.getExpressions().add(criteriaBuilder.like(root.get("name"),"%"+book.getName()+"%"));
                   }
                   if (book.getAuthor()!=null && !"".equals(book.getAuthor())){
                       predicate.getExpressions().add(criteriaBuilder.like(root.get("author"),"%"+book.getAuthor()+"%"));
                   }
               }
                return predicate;
            }
        });
        modelAndView.addObject("bookList",  bookList);
        modelAndView.setViewName("bookList");
        return modelAndView;
    }


    @RequestMapping( value = "/add",method = RequestMethod.POST)
    public  String add(Book book){
        bookDao.save(book);
        return  "redirect:/book/list";
    }
    @RequestMapping("/preUpdate/{id}")
    public  ModelAndView preUpdate(@PathVariable("id") Integer id){
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("bookList",   bookDao.getOne(id));
        modelAndView.setViewName("bookupdate");

        return modelAndView;

    }

    @PostMapping(value = "/update")
    public  String update(Book book){
        bookDao.save(book);
        return  "redirect:/book/list";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        bookDao.delete(id);
        return  "redirect:/book/list";
    }
    @ResponseBody
    @RequestMapping("/queryByName")
    public List<Book> queryByName(){
        return bookDao.findByNameLike("理");
    }
    @ResponseBody
    @RequestMapping("/randomList")
    public List<Book> randomList(){
        return bookDao.randomList(2);
    }
}
