package com.company.unicef.screen.blog;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Blog;

@UiController("Blog.browse")
@UiDescriptor("blog-browse.xml")
@LookupComponent("blogsTable")
public class BlogBrowse extends StandardLookup<Blog> {
}