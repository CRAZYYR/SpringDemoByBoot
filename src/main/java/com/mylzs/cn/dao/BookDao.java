package com.mylzs.cn.dao;

import com.mylzs.cn.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 17/12/3.
 */
public interface BookDao extends JpaRepository<Book,Integer> ,JpaSpecificationExecutor<Book>{
    @Query("select b from Book b where b.name like %?1% ")
        public List<Book> findByNameLike ( String name);
    @Query(value = "select * from t_book order by RAND() LIMIT ?1",nativeQuery = true)
    public List<Book> randomList ( Integer n);
}
