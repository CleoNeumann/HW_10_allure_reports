import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo) {
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Открываем репозитторий {repo}")
    public void openRepository(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб issues")
    public void openTabIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldFindIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(exist);
    }
}