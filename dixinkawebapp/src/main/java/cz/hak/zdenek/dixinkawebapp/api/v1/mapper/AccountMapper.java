package cz.hak.zdenek.dixinkawebapp.api.v1.mapper;

import cz.hak.zdenek.dixinkawebapp.api.v1.model.AccountDTO;
import cz.hak.zdenek.dixinkawebapp.domain.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO accountToAccountDTO(Account account);

    Account accountDtoToAccount(AccountDTO accountDTO);
}
