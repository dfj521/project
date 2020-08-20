package com.dfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestfulController {

    /*@RequestMapping(value="/book/1",method= RequestMethod.GET)
    public String queryBookById() {
        System.out.println("根据id查询一本图书");
        return "/restful.jsp";
    }*/

    @RequestMapping(value="/book",method=RequestMethod.GET)
    public String queryBooks() {
        System.out.println("查询全部图书");
        return "/restful.jsp";
    }

    @RequestMapping(value="/book",method=RequestMethod.POST)
    public String addBook() {
        System.out.println("post请求  添加图书");
        return "/restful.jsp";
    }

    @RequestMapping(value="/book/1",method=RequestMethod.PUT)
    public String updateBook() {
        System.out.println("修改图书");
        return "/restful.jsp";
    }

    @RequestMapping(value="/book/1",method=RequestMethod.DELETE)
    public String deleteBook() {
        System.out.println("删除图书");
        return "/restful.jsp";
    }

    /**
     * @PathVariable 注解表示取路径参数的值。<br/>
     * 	value="/book/{id}" 这里我们把id写成了{id}这是路径参数<br/>
     *  @PathVariable(name="id") 这里的name属性表示把路径参数id的值注入到请求方法的id参数中
     */
    @RequestMapping(value="/book/{id}",method=RequestMethod.GET)
    public String queryBookById(@PathVariable(name="id") Integer id) {
        System.out.println("根据id查询一本图书。 id ====>>>> " + id);
        return "/restful.jsp";
    }

    /**
     * @PathVariable 注解表示取路径参数的值。<br/>
     *               value="/book/{id}" 这里我们把id写成了{id}这是路径参数<br/>
     * @PathVariable(name="id") 这里的name属性表示把路径参数id的值注入到请求方法的id参数中<br/>
     * 	name的属性，表示取路径中哪个参数。默认情况下。参数名是name的值<br/>
     */
    @RequestMapping(value = "/book/{id}/{abc}", method = RequestMethod.GET)
    public String queryBookById(@PathVariable(name = "id") Integer id,
                                @PathVariable(name = "abc") String abc) {
        System.out.println("根据id查询一本图书。 id ====>>>> " + id);
        System.out.println("abc ===>>>> " + abc);
        return "/restful.jsp";
    }

}
