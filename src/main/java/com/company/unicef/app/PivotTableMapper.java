package com.company.unicef.app;

import com.company.unicef.entity.PivotTableCheckBoxes;
import com.company.unicef.entity.SecondForm;
import com.vaadin.server.VaadinSession;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Component
public class PivotTableMapper {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private Messages messages;

    private static final String lowRu = "Низкий";
    private static final String mediumRu = "Средний";
    private static final String highRu = "Высокий";
    private static final String homeCategoryRu = "ЖИЛЬЕ, РАБОТА, ДОХОД СЕМЬИ";
    private static final String parentsCategoryRu = "БАЗОВЫЙ УХОД ОБЕСПЕЧЕНИЕ БЕЗОПАСНОСТИ";
    private static final String selfCategoryRu = "НАВЫКИ СМООБСЛУЖИВАНИЯ/УХОД ЗА СОБОЙ";
    private static final String familyCategoryRu = "СЕМЬЯ И СОЦИАЛЬНЫЕ ОТНОШЕНИЯ";
    private static final String identCategoryRu = "ИДЕНТИЧНОСТЬ И СОЦИАЛЬНАЯ ПРЕЗЕНТАЦИЯ";
    private static final String emoCategoryRu = "ЭМОЦИОНАЛЬНОЕ И ПОВЕДЕНЧЕСКОЕ РАЗВИТИЕ";
    private static final String eduCategoryRu = "ОБРАЗОВАНИЕ";
    private static final String healthCategoryRu = "ЗДОРОВЬЕ";

    private static final String lowEn = "Low";
    private static final String mediumEn = "Medium";
    private static final String highEn = "High";
    private static final String homeCategoryEn = "Home, work, family income";
    private static final String parentsCategoryEn = "Basic care, safety";
    private static final String selfCategoryEn = "Self-care skills";
    private static final String familyCategoryEn = "Family and social relations";
    private static final String identCategoryEn = "Identity and social presentation";
    private static final String emoCategoryEn = "Emotional and behavioral development";
    private static final String eduCategoryEn = "Education";
    private static final String healthCategoryEn = "Health";

    private static final String lowKk = "Төмен";
    private static final String mediumKk = "Орташа";
    private static final String highKk = "Жоғары";
    private static final String homeCategoryKk = "Үй, жұмыс, отбасы кірісі";
    private static final String parentsCategoryKk = "Негізгі күтім, қауіпсіздік";
    private static final String selfCategoryKk = "Өзіне-өзі қызмет ету дағдылары";
    private static final String familyCategoryKk = "Отбасы және әлеуметтік қарым-қатынастар";
    private static final String identCategoryKk = "Жеке басы және әлеуметтік көрініс";
    private static final String emoCategoryKk = "Эмоционалды және мінез-құлық дамуы";
    private static final String eduCategoryKk = "Білім";
    private static final String healthCategoryKk = "Денсаулық";



    public List<PivotTableCheckBoxes> convert(SecondForm secondForm) {
        List<PivotTableCheckBoxes> list = new ArrayList<>();
        DataHolder[] dataHolders = getDataHolders(secondForm);
        for (DataHolder dataHolder : dataHolders) {
            boolean isChecked = Boolean.TRUE.equals(dataHolder.method.get());
            if (isChecked) {
                list.add(createPivotTableCheckBox(
                        dataHolder.category,
                        dataHolder.level,
                        messages.getMessage("com.company.unicef.entity", String.format("SecondForm.%s", dataHolder.name)), // TODO: поменять чтобы автоматом брало package
                        secondForm));
            }
        }
        return list;
    }

    private DataHolder[] getDataHolders(SecondForm secondForm) {
        String low = "";
        String medium = "";
        String high = "";
        String homeCategory = "";
        String parentsCategory = "";
        String selfCategory = "";
        String familyCategory = "";
        String identCategory = "";
        String emoCategory = "";
        String eduCategory = "";
        String healthCategory = "";

        String language = VaadinSession.getCurrent().getLocale().getLanguage();
        if (language.equals("ru")) {
            low = lowRu;
            medium = mediumRu;
            high = highRu;
            homeCategory = homeCategoryRu;
            parentsCategory = parentsCategoryRu;
            selfCategory = selfCategoryRu;
            familyCategory = familyCategoryRu;
            identCategory = identCategoryRu;
            emoCategory = emoCategoryRu;
            eduCategory = eduCategoryRu;
            healthCategory = healthCategoryRu;
        } else if (language.equals("en")) {
            low = lowEn;
            medium = mediumEn;
            high = highEn;
            homeCategory = homeCategoryEn;
            parentsCategory = parentsCategoryEn;
            selfCategory = selfCategoryEn;
            familyCategory = familyCategoryEn;
            identCategory = identCategoryEn;
            emoCategory = emoCategoryEn;
            eduCategory = eduCategoryEn;
            healthCategory = healthCategoryEn;
        } else if (language.equals("kk")) {
            low = lowKk;
            medium = mediumKk;
            high = highKk;
            homeCategory = homeCategoryKk;
            parentsCategory = parentsCategoryKk;
            selfCategory = selfCategoryKk;
            familyCategory = familyCategoryKk;
            identCategory = identCategoryKk;
            emoCategory = emoCategoryKk;
            eduCategory = eduCategoryKk;
            healthCategory = healthCategoryKk;
        } else {
            low = lowRu;
            medium = mediumRu;
            high = highRu;
            homeCategory = homeCategoryRu;
            parentsCategory = parentsCategoryRu;
            selfCategory = selfCategoryRu;
            familyCategory = familyCategoryRu;
            identCategory = identCategoryRu;
            emoCategory = emoCategoryRu;
            eduCategory = eduCategoryRu;
            healthCategory = healthCategoryRu;
        }


        return new DataHolder[]{
                // Home Checkboxes
                new DataHolder("homeNoHome", homeCategory, low, secondForm::getHomeNoHome),
                new DataHolder("homeEviction", homeCategory, medium, secondForm::getHomeEviction),
                new DataHolder("homeDanger", homeCategory, medium, secondForm::getHomeDanger),
                new DataHolder("homeNoJob", homeCategory, medium, secondForm::getHomeNoJob),
                new DataHolder("homeNoBenefits", homeCategory, medium, secondForm::getHomeNoBenefits),
                new DataHolder("homeNoMoney", homeCategory, medium, secondForm::getHomeNoMoney),

                // Parents Checkboxes
                new DataHolder("parentsNoDailyRoutine", parentsCategory, low, secondForm::getParentsNoDailyRoutine),
                new DataHolder("parentsNoPraised", parentsCategory, low, secondForm::getParentsNoPraised),
                new DataHolder("parentsDontKnow", parentsCategory, low, secondForm::getParentsDontKnow),
                new DataHolder("parentsNoSpace", parentsCategory, medium, secondForm::getParentsNoSpace),
                new DataHolder("parentsNoSchool", parentsCategory, medium, secondForm::getParentsNoSchool),
                new DataHolder("parentsDontCare", parentsCategory, medium, secondForm::getParentsDontCare),
                new DataHolder("parentNoDiscipline", parentsCategory, medium, secondForm::getParentNoDiscipline),
                new DataHolder("parentsNoBasic", parentsCategory, high, secondForm::getParentsNoBasic),
                new DataHolder("parentsNoChildHealth", parentsCategory, high, secondForm::getParentsNoChildHealth),

                // Self Checkboxes
                new DataHolder("selfNoPhysicialActivity", selfCategory, low, secondForm::getSelfNoPhysicialActivity),
                new DataHolder("selfNoPracticalSkills", selfCategory, low, secondForm::getSelfNoPracticalSkills),
                new DataHolder("selfNoMoney", selfCategory, low, secondForm::getSelfNoMoney),
                new DataHolder("selfNoHelp", selfCategory, medium, secondForm::getSelfNoHelp),

                // Family Checkboxes
                new DataHolder("familyDifferentParents", familyCategory, low, secondForm::getFamilyDifferentParents),
                new DataHolder("familyNoTimeCommunication", familyCategory, low, secondForm::getFamilyNoTimeCommunication),
                new DataHolder("familyNoRelationship", familyCategory, medium, secondForm::getFamilyNoRelationship),
                new DataHolder("familyNoAdult", familyCategory, medium, secondForm::getFamilyNoAdult),
                new DataHolder("familyNoConnection", familyCategory, medium, secondForm::getFamilyNoConnection),
                new DataHolder("familyBadReview", familyCategory, medium, secondForm::getFamilyBadReview),
                new DataHolder("familyBadFriends", familyCategory, medium, secondForm::getFamilyBadFriends),
                new DataHolder("familyNoSkills", familyCategory, medium, secondForm::getFamilyNoSkills),
                new DataHolder("familyChildIsAdult", familyCategory, medium, secondForm::getFamilyChildIsAdult),
                new DataHolder("familyAwayFromParents", familyCategory, medium, secondForm::getFamilyAwayFromParents),
                new DataHolder("familyChildParentConflict", familyCategory, medium, secondForm::getFamilyChildParentConflict),
                new DataHolder("familyChronicalDisease", familyCategory, medium, secondForm::getFamilyChronicalDisease),
                new DataHolder("familyHasJail", familyCategory, medium, secondForm::getFamilyHasJail),
                new DataHolder("familyHasTrauma", familyCategory, medium, secondForm::getFamilyHasTrauma),
                new DataHolder("familyDomesticViolence", familyCategory, high, secondForm::getFamilyDomesticViolence),
                new DataHolder("familyChildConflict", familyCategory, high, secondForm::getFamilyChildConflict),
                new DataHolder("familySexualProblems", familyCategory, high, secondForm::getFamilySexualProblems),

                // Identity Checkboxes
                new DataHolder("identNotSureMyself", identCategory, low, secondForm::getIdentNotSureMyself),
                new DataHolder("identNotSatisfied", identCategory, low, secondForm::getIdentNotSatisfied),
                new DataHolder("identNoCultural", identCategory, low, secondForm::getIdentNoCultural),
                new DataHolder("identNotIndependent", identCategory, low, secondForm::getIdentNotIndependent),
                new DataHolder("identNoFamily", identCategory, medium, secondForm::getIdentNoFamily),
                new DataHolder("identGenderConf", identCategory, medium, secondForm::getIdentGenderConf),
                new DataHolder("identPositiveIndividual", identCategory, medium, secondForm::getIdentPositiveIndividual),
                new DataHolder("identAgeSol", identCategory, medium, secondForm::getIdentAgeSol),
                new DataHolder("identNoHygiene", identCategory, medium, secondForm::getIdentNoHygiene),
                new DataHolder("identDiscrimination", identCategory, high, secondForm::getIdentDiscrimination),
                new DataHolder("identGenderDontKnow", identCategory, high, secondForm::getIdentGenderDontKnow),

                // Education Checkboxes
                new DataHolder("eduNotLike", eduCategory, high, secondForm::getEduNotLike),
                new DataHolder("eduSpecialNeeds", eduCategory, high, secondForm::getEduSpecialNeeds),
                new DataHolder("eduDifficultProgram", eduCategory, high, secondForm::getEduDifficultProgram),
                new DataHolder("eduFreqAbsent", eduCategory, high, secondForm::getEduFreqAbsent),
                new DataHolder("eduAmoralAbsent", eduCategory, high, secondForm::getEduAmoralAbsent),
                new DataHolder("eduWorking", eduCategory, medium, secondForm::getEduWorking),
                new DataHolder("eduNoDiscipline", eduCategory, medium, secondForm::getEduNoDiscipline),
                new DataHolder("eduNoAttention", eduCategory, medium, secondForm::getEduNoAttention),
                new DataHolder("eduNoStationery", eduCategory, medium, secondForm::getEduNoStationery),
                new DataHolder("eduNoLaptop", eduCategory, medium, secondForm::getEduNoLaptop),
                new DataHolder("eduNoUniform", eduCategory, medium, secondForm::getEduNoUniform),
                new DataHolder("eduConflict", eduCategory, medium, secondForm::getEduConflict),
                new DataHolder("eduNoDesk", eduCategory, medium, secondForm::getEduNoDesk),
                new DataHolder("eduLowMotivation", eduCategory, medium, secondForm::getEduLowMotivation),
                new DataHolder("eduNoSubject", eduCategory, low, secondForm::getEduNoSubject),
                new DataHolder("eduSchoolFriend", eduCategory, low, secondForm::getEduSchoolFriend),
                new DataHolder("eduNoClub", eduCategory, low, secondForm::getEduNoClub),

                // Health Checkboxes
                new DataHolder("healthNoFood", healthCategory, high, secondForm::getHealthNoFood),
                new DataHolder("healthNoEquipment", healthCategory, high, secondForm::getHealthNoEquipment),
                new DataHolder("healthNoCoordination", healthCategory, high, secondForm::getHealthNoCoordination),
                new DataHolder("healthBadHabits", healthCategory, high, secondForm::getHealthBadHabits),
                new DataHolder("healthWetsBed", healthCategory, high, secondForm::getHealthWetsBed),
                new DataHolder("healthBadCommunication", healthCategory, high, secondForm::getHealthBadCommunication),
                new DataHolder("healthChronical", healthCategory, medium, secondForm::getHealthChronical),
                new DataHolder("healthNoRegistered", healthCategory, medium, secondForm::getHealthNoRegistered),
                new DataHolder("healthDisabledNoHelp", healthCategory, medium, secondForm::getHealthDisabledNoHelp),
                new DataHolder("healthNoHospital", healthCategory, medium, secondForm::getHealthNoHospital),
                new DataHolder("healthNoTesting", healthCategory, medium, secondForm::getHealthNoTesting),
                new DataHolder("healthBadWeightOrHeight", healthCategory, medium, secondForm::getHealthBadWeightOrHeight),
                new DataHolder("healthFobia", healthCategory, medium, secondForm::getHealthFobia),
                new DataHolder("healthBadSleep", healthCategory, medium, secondForm::getHealthBadSleep),
                new DataHolder("healthHasTrauma", healthCategory, medium, secondForm::getHealthHasTrauma),
                new DataHolder("healthNoVaccination", healthCategory, low, secondForm::getHealthNoVaccination),
                new DataHolder("healthNoSport", healthCategory, low, secondForm::getHealthNoSport),

                // Emo Checkboxes
                new DataHolder("emoNoStability", emoCategory, medium, secondForm::getEmoNoStability),
                new DataHolder("emoNoFriends", emoCategory, medium, secondForm::getEmoNoFriends),
                new DataHolder("emoOutsideOfHome", emoCategory, medium, secondForm::getEmoOutsideOfHome),
                new DataHolder("emoAlone", emoCategory, medium, secondForm::getEmoAlone),
                new DataHolder("emoSelfHarassment", emoCategory, medium, secondForm::getEmoSelfHarassment),
                new DataHolder("emoRanAway", emoCategory, medium, secondForm::getEmoRanAway),
                new DataHolder("emoIsBully", emoCategory, medium, secondForm::getEmoIsBully),
                new DataHolder("emoRiskingAction", emoCategory, medium, secondForm::getEmoRiskingAction),
                new DataHolder("emoConflictWitness", emoCategory, medium, secondForm::getEmoConflictWitness),
                new DataHolder("emoNoEmotionControl", emoCategory, medium, secondForm::getEmoNoEmotionControl),
                new DataHolder("emoSteals", emoCategory, medium, secondForm::getEmoSteals),
                new DataHolder("emoOnRegister", emoCategory, medium, secondForm::getEmoOnRegister),
                new DataHolder("emoAnxiety", emoCategory, high, secondForm::getEmoAnxiety),
                new DataHolder("emoDepression", emoCategory, high, secondForm::getEmoDepression),
                new DataHolder("emoBullying", emoCategory, high, secondForm::getEmoBullying),
                new DataHolder("emoSuicidial", emoCategory, high, secondForm::getEmoSuicidial),
                new DataHolder("emoSuicidialAttempt", emoCategory, high, secondForm::getEmoSuicidialAttempt),
                new DataHolder("emoAggressor", emoCategory, high, secondForm::getEmoAggressor)
        };
    }

    private PivotTableCheckBoxes createPivotTableCheckBox(String category, String level, String description, SecondForm secondForm) {
        PivotTableCheckBoxes pivotTableCheckBoxes = dataManager.create(PivotTableCheckBoxes.class);
        pivotTableCheckBoxes.setCategory(category);
        pivotTableCheckBoxes.setLevel(level);
        pivotTableCheckBoxes.setDescription(description);
        pivotTableCheckBoxes.setSecondForm(secondForm);
        return pivotTableCheckBoxes;
    }

    private record DataHolder(String name, String category, String level, Supplier<Boolean> method) {
    }
}