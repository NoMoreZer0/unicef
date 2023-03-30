package swag.rest.nis_risk_app.service.internal;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swag.rest.nis_risk_app.dao.NewsRepository;
import swag.rest.nis_risk_app.dto.NewsDto;
import swag.rest.nis_risk_app.dto.UpdateNewsDto;
import swag.rest.nis_risk_app.entity.News;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public News createNews(NewsDto newsDto) {
        News news = News.builder().label(newsDto.getLabel())
            .topic(newsDto.getTopic())
            .timestamp(LocalDateTime.now())
            .build();
        return newsRepository.save(news);
    }

    public News updateNews(UpdateNewsDto news) {
        News current = newsRepository.findById(news.getId())
            .orElseThrow(EntityNotFoundException::new);
        current.setLabel(news.getLabel())
            .setTopic(news.getTopic());
        return newsRepository.save(current);
    }

    public News getNews(Long id) {
        return newsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public void deleteNews(Long id) {
        newsRepository.delete(getNews(id));
    }
}
