package bg.softuni.springdatalab.services;

import bg.softuni.springdatalab.models.Account;
import bg.softuni.springdatalab.models.User;
import bg.softuni.springdatalab.repositories.AccountRepository;
import bg.softuni.springdatalab.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {

        Account account = accountRepository.findAccountById(id);

        if (account == null) {
            return;
        }

        if (account.getBalance().compareTo(money) >= 0) {
            account.setBalance(account.getBalance().subtract(money));
        }
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {

        Account account = accountRepository.findAccountById(id);

        if (account.getUser() != null) {
            if (money.compareTo(BigDecimal.ZERO) == 1) {
                account.setBalance(account.getBalance().subtract(money));
            }
        }

    }
}
