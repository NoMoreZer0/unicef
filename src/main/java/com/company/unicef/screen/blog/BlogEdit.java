package com.company.unicef.screen.blog;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Blog;

@UiController("Blog.edit")
@UiDescriptor("blog-edit.xml")
@EditedEntityContainer("blogDc")
public class BlogEdit extends StandardEditor<Blog> {
}