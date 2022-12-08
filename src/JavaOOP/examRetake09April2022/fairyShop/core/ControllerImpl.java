package JavaOOP.examRetake09April2022.fairyShop.core;

import JavaOOP.examRetake09April2022.fairyShop.common.ConstantMessages;
import JavaOOP.examRetake09April2022.fairyShop.models.*;
import JavaOOP.examRetake09April2022.fairyShop.repositories.HelperRepository;
import JavaOOP.examRetake09April2022.fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static JavaOOP.examRetake09April2022.fairyShop.common.ConstantMessages.*;
import static JavaOOP.examRetake09April2022.fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private HelperRepository<Helper> helperRepository = new HelperRepository<>();
    private PresentRepository<Present> presentRepository = new PresentRepository<>();
    private Shop shop = new ShopImpl();

    @Override
    public String addHelper(String type, String helperName) {

        Helper helper;

        if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {


        if (helperRepository.findByName(helperName) == null) {

            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);

        }
        Instrument instrument = new InstrumentImpl(power);
        helperRepository.findByName(helperName).addInstrument(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> helpersWhoCanCraft = helperRepository.getModels()
                .stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());

        if (helpersWhoCanCraft.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        long countBrokenPresents = 0;
        Present present = presentRepository.findByName(presentName);


        for (Helper helper : helpersWhoCanCraft) {
            shop.craft(present, helper);
            countBrokenPresents += helper.getInstruments().stream().filter(Instrument::isBroken).count();

            if (present.isDone()) {
                break;
            }
        }

        if (present.isDone()) {
            return String.format(ConstantMessages.PRESENT_DONE, presentName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, countBrokenPresents);
        }
        return String.format(ConstantMessages.PRESENT_DONE, presentName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, countBrokenPresents);
}

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(presentRepository.getModels().size()).append(" presents are done!")
                .append(System.lineSeparator())
                .append("Helpers info:")
                .append(System.lineSeparator());

        for (Helper helper : helperRepository.getModels()) {
            sb.append("Name: ").append(helper.getName()).append(System.lineSeparator())
                    .append("Energy: ").append(helper.getEnergy()).append(System.lineSeparator())
                    .append("Instruments: ").append(helper.getInstruments().stream().filter(instrument -> !instrument.isBroken()).count())
                    .append(" not broken left")
                    .append(System.lineSeparator());
        }


        return sb.toString();
    }
}
