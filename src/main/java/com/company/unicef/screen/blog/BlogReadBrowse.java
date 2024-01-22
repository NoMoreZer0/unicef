package com.company.unicef.screen.blog;

import io.jmix.core.DataManager;
import io.jmix.ui.component.Label;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("BlogRead.browse")
@UiDescriptor("blog-read-browse.xml")
@LookupComponent("blogHtml")
public class BlogReadBrowse extends StandardLookup<Blog> {
    @Autowired
    private Label<String> blogHtml;
    @Autowired
    private DataManager dataManager;

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        List<Blog> blogs = dataManager.load(Blog.class)
                .query("select e from Blog e order by e.createdDate desc")
                .list();

        StringBuilder html = new StringBuilder();

        html.append("<div style=\"margin-left: 200px; width: 1000px;\">");

        html.append("""
                <div style="background-color: #E1F0DA; padding: 15px; margin-bottom: 15px; border-radius: 10px;">
                    <h2 style="font-weight: bold;">Блог кейс менеджера</h2>
                </div>
                """);

        for (Blog blog : blogs) {
            html.append(String.format("""
                    <div style="background-color: #E1F0DA; padding: 15px; margin-bottom: 15px; border-radius: 10px;">
                        <h3 style="word-break: break-word; font-weight: bold;">
                            %s
                        </h3>
                        <div style="margin-bottom: 10px; color: #909090;">
                            %s
                        </div>
                        <p style="word-wrap: break-word; white-space: pre-wrap; word-spacing: 0.05em; line-height: 1.4; color: black; font-size: 1.1em;">%s</p>
                    </div>
                    """,
                    blog.getTitle(),
                    blog.getCreatedDate(),
                    blog.getBody()));
        }

        html.append("</div>");

        blogHtml.setValue(html.toString());
    }
}