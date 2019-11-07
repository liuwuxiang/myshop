package com.lwx.my.shop.web.admin.web.controller;

import com.lwx.my.shop.commons.dto.BaseResult;
import com.lwx.my.shop.domain.TbContent;
import com.lwx.my.shop.web.admin.abstracts.AbstractBaseController;
import com.lwx.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 内容管理
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 *
 * @author 刘武祥
 * @version 1.0.0
 * @date 2018/6/25 14:23
 */
@Controller
@RequestMapping(value = "content")
public class ContentController extends AbstractBaseController<TbContent, TbContentService> {

    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;

        // id 不为空，则从数据库获取
        if (id != null) {
            tbContent = service.getById(id);
        } else {
            tbContent = new TbContent();
        }

        return tbContent;
    }

    /**
     * 功能说明:跳转内容列表页
     *
     * @return java.lang.String
     * @author 刘武祥
     * @date 2019/8/27 0027 15:32
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "content_list";
    }

    /**
     * 功能说明:跳转表单页
     *
     * @return java.lang.String
     * @author 刘武祥
     * @date 2019/8/27 0027 15:33
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content_form";
    }

    /**
     * 功能说明:保存
     *
     * @param entity                实体
     * @param model                 模型数据
     * @param redirectAttributes
     * @return java.lang.String
     * @author 刘武祥
     * @date 2019/8/27 0027 15:34
     */
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent entity, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(entity);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "content_form";
        }
    }

    /**
     * 功能说明:删除
     *
     * @param ids   删除的id数组
     * @return com.lwx.my.shop.commons.dto.BaseResult
     * @author 刘武祥
     * @date 2019/8/27 0027 15:35
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除内容成功");
        } else {
            baseResult = BaseResult.fail("删除内容失败");
        }

        return baseResult;
    }

    /**
     * 跳转详情页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "content_detail";
    }
}
