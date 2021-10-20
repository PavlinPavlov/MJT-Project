package tu.p_pavlov.mjt.project.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tu.p_pavlov.mjt.project.api.dto.ItemReadDto;
import tu.p_pavlov.mjt.project.domain.model.Item;

@Configuration
public class ModelMapperConfig {
    @Bean
    public static ModelMapper configure() {
        final ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(Item.class, ItemReadDto.class);

        return modelMapper;
    }
}
