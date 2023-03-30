package swag.rest.nis_risk_app.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import swag.rest.nis_risk_app.dto.NewsDto;
import swag.rest.nis_risk_app.dto.UpdateNewsDto;
import swag.rest.nis_risk_app.entity.News;
import swag.rest.nis_risk_app.service.internal.NewsService;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CrossOrigin(origins = "*")
    @PostMapping("/news")
    public News createNews(@RequestBody NewsDto newsDto) {
        return newsService.createNews(newsDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CrossOrigin(origins = "*")
    @PutMapping("/news")
    public News updateNews(@RequestBody UpdateNewsDto news) {
        return newsService.updateNews(news);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/news/{id}")
    public News getNews(@PathVariable Long id) {
        return newsService.getNews(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/news/{id}")
    public String deleteNews(@PathVariable Long id) {
         newsService.deleteNews(id);
         return HttpStatus.OK.getReasonPhrase();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/news")
    public List<News> getNews() {
        return newsService.getAll();
    }

}
