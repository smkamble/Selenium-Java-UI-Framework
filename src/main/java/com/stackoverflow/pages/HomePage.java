package com.stackoverflow.pages;

import com.stackoverflow.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Browse questions')]")
    public WebElement browseQuestions;

    @FindBy(id = "nav-tags")
    public WebElement tags;


    @FindBy(css = "a[data-value='name']")
    public WebElement name;

    @FindBy(css = ".mt-auto>div.grid--cell:nth-child(1)")
    public List<WebElement> questionCounts;

    @FindBy(css = "a[rel='tag']")
    public List<WebElement> tagNames;

    public void clickBrowseQuestion() {
        scrollToElement(browseQuestions);
        waitAndClick(browseQuestions);

    }

    public void clickTags() {
        tags.click();
    }

    public void clickName() {
        name.click();
    }

    public <K, V extends Comparable<V>> Map.Entry<String, Integer> getMaxQuestionCount() {
        HashMap<String, Integer> tagWithCountMap = new HashMap();
        for (int i = 0; i < questionCounts.size(); i++) {
            tagWithCountMap.put(tagNames.get(i).getText(), Integer.parseInt(questionCounts.get(i).getText().split("\\s+")[0]));
        }
        return getMaxEntryInMapBasedOnValue(tagWithCountMap);
    }

    public static <K, V extends Comparable<V>> Map.Entry<K, V> getMaxEntryInMapBasedOnValue(Map<K, V> map) {
        Optional<Map.Entry<K, V>> maxEntry = map.entrySet()
                .stream()
                .max((Map.Entry<K, V> e1, Map.Entry<K, V> e2) -> e1.getValue()
                        .compareTo(e2.getValue())
                );
        return maxEntry.get();
    }
}
