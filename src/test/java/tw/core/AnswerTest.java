package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_create_an_Answer_with_a_number_list_by_createAnswer_when_give_a_String(){
        //give
        String input="5 2 8 4";

        //when
        Answer result=Answer.createAnswer(input);

        //then
        assertThat(result.toString(),is(input));
    }


}