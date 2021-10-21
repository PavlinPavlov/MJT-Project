package tu.p_pavlov.mjt.project.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tu.p_pavlov.mjt.project.api.dto.ItemReadDto;
import tu.p_pavlov.mjt.project.api.dto.PurchaseWriteDto;
import tu.p_pavlov.mjt.project.domain.model.Item;
import tu.p_pavlov.mjt.project.domain.model.Purchase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {
    @Bean
    public static ModelMapper configure() {
        final ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(Item.class, ItemReadDto.class);

        modelMapper.typeMap(PurchaseWriteDto.class, Purchase.class)
                .<String>addMapping(PurchaseWriteDto::getClientId,
                        (destination, value) -> destination.getClient().setId(value))
                .addMappings(mMapper -> mMapper.using(new PurchaseWriteConverter())
                        .map(PurchaseWriteDto::getItemIds, Purchase::setItems)
                );

        return modelMapper;
    }

    public static class PurchaseWriteConverter extends AbstractConverter<List<String>, Set<Item>> {

        @Override
        protected Set<Item> convert(List<String> users) {

            return users.stream().map(id -> {
                        Item item = new Item();
                        item.setId(id);
                        return item;
                    })
                    .collect(Collectors.toSet());
        }
    }
}
