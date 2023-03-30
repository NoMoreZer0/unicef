package swag.rest.nis_risk_app.service.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.rest.nis_risk_app.dao.ParentRepository;
import swag.rest.nis_risk_app.dto.ParentDto;
import swag.rest.nis_risk_app.entity.Parent;
import swag.rest.nis_risk_app.service.ParentService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Parent saveParent(ParentDto parentDto) {
        Parent parent = modelMapper.map(parentDto, Parent.class);
        log.info(parent + " - parent");
        return parentRepository.save(parent);
    }

    @Override
    public List<Parent> getAll() {
        return parentRepository.findAll();
    }

    @Override
    public Optional<Parent> findById(Long id) {
        return parentRepository.findById(id);
    }
}
