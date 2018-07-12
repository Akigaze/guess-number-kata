package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

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
    public void should_out_put_a_number_String_when_call_toString(){
        //give
        Answer answer=new Answer();
        String[] number=new String[]{"1","2","4","8"};
        answer.setNumList(Arrays.asList(number));
        String result="1 2 4 8";
        //when
        String actual=answer.toString();
        //then
        assertThat(actual,is(result));
    }

    @Test
    public void should_get_the_right_index_when_call_getIndexOfNum(){
        //give
        Answer answer=new Answer();
        String[] number=new String[]{"1","2","4","8"};
        answer.setNumList(Arrays.asList(number));
        int index1=2;
        int index2=3;
        //when
        int result1=answer.getIndexOfNum("4");
        int result2=answer.getIndexOfNum("8");
        //then
        assertThat(index1,is(result1));
        assertThat(index2,is(result2));

    }

    @Test
    public void should_create_an_Answer_with_a_number_list_by_createAnswer_when_give_a_String(){
        //give
        String input="       5 2 8 4";

        //when
        Answer result=Answer.createAnswer(input);

        //then
        assertThat(result.toString(),is(input));
    }

    @Test
    public void should_successfully_validate_when_give_a_String_with_right_format(){
        //give
        String input="5 2 8 4";

        //when
        Answer result=Answer.createAnswer(input);

        //then
        try {
            result.validate();
        } catch (AnswerFormatIncorrectException e) {
            fail("Answer format is incorrect");
        }
    }

    @Test
    public void should_successfully_validate_when_give_a_String_with_wrong_format(){
        //give
        String input1="5 111 2 7";
        String input2="5 1 2 1";

        //when
        Answer result1=Answer.createAnswer(input1);
        Answer result2=Answer.createAnswer(input2);

        //then
        try {
            result1.validate();
            fail("Answer format is incorrect");
        } catch (AnswerFormatIncorrectException e) {
            try {
                result2.validate();
                fail("Answer format is incorrect");
            } catch (AnswerFormatIncorrectException e1) { }
        }
    }

    @Test
    public void should_get_a_Record_by_check_when_give_a_String(){
        //give
        Answer answer=Answer.createAnswer("1 3 5 6");
        String result="1A1B";
        //when
        Record record=actualAnswer.check(answer);
        //then
        assertThat(record.getValue(),is(result));
    }

}