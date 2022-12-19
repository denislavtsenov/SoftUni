package magicGame.models.region;

import magicGame.models.magicians.Magician;
import magicGame.models.magics.Magic;
import magicGame.repositories.interfaces.MagicRepository;
import magicGame.repositories.interfaces.MagicRepositoryImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegionImpl implements Region {

    @Override
    public String start(Collection<Magician> magicians) {
        MagicRepository<Magic> magicRepository = new MagicRepositoryImpl();

        List<Magician> wizardsList = magicians.stream().filter(magician -> magician.getClass().getSimpleName()
                .equals("Wizard")).collect(Collectors.toList());

        List<Magician> blackWidowsList = magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList());

        while (!wizardsList.isEmpty() && !blackWidowsList.isEmpty()) {

            for (Magician wizard : wizardsList) {
                int wizardBullets = wizard.getMagic().getBulletsCount();

                for (Magician blackWidow : blackWidowsList) {
                    while (wizardBullets > 0 && blackWidow.isAlive()) {

                        int wizardDamage = wizard.getMagic().fire();
                        blackWidow.takeDamage(wizardDamage);
                        wizardBullets -= wizardDamage;
                    }

                    if (!blackWidow.isAlive()) {
                        blackWidowsList.remove(blackWidow);
                    }
                }
            }

            for (Magician blackWidow : blackWidowsList) {
                for (Magician wizard : wizardsList) {
                    int blackWidowBullets = blackWidow.getMagic().getBulletsCount();
                    while (blackWidowBullets > 0 && wizard.isAlive()) {
                        int blackWidowDamage = blackWidow.getMagic().fire();
                        wizard.takeDamage(blackWidowDamage);
                        blackWidowBullets -= blackWidowDamage;
                    }

                    if (!wizard.isAlive()) {
                        wizardsList.remove(wizard);
                    }
                }
            }
        }

        if (wizardsList.isEmpty()) {
            return String.format("Black widows win!");
        }

        return String.format("Wizards win!");
    }
}
