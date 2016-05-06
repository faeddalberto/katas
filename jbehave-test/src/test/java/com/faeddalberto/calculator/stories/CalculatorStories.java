package com.faeddalberto.calculator.stories;

import com.faeddalberto.calculator.steps.AddTwoNumbersSteps;
import com.faeddalberto.calculator.steps.DivideTwoNumbersSteps;
import com.faeddalberto.calculator.steps.MultiplyTwoNumbersSteps;
import com.faeddalberto.calculator.steps.SubstractTwoNumbersSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.reporters.Format.*;

public class CalculatorStories extends JUnitStories {

    public CalculatorStories(){
        super();
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                    .useStoryLoader(
                            new LoadFromClasspath(this.getClass().getClassLoader()))
                    .useStoryReporterBuilder(
                            new StoryReporterBuilder()
                                    .withDefaultFormats()
                                    .withFormats(CONSOLE)
                    );
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        List<Steps> steps = new ArrayList<>();
        steps.add(new AddTwoNumbersSteps());
        steps.add(new SubstractTwoNumbersSteps());
        steps.add(new MultiplyTwoNumbersSteps());
        steps.add(new DivideTwoNumbersSteps());

        return new InstanceStepsFactory(configuration(), steps);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().
                findPaths(CodeLocations.codeLocationFromClass(
                        this.getClass()), Arrays.asList("**/*.story"), Arrays.asList(""));
    }
}

