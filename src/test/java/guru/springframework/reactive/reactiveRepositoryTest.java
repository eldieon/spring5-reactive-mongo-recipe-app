package guru.springframework.reactive;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.reactive.RecipeReactiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class reactiveRepositoryTest {

    @Autowired
    RecipeReactiveRepository recipeReactiveRepository;

    @Before
    public void setup(){
        //what do u have to mock, and what do u want to test?
        //want to test that the categories are in the repo when u start the program.
        //why does this test take forever?
    }


    @Test
    public void testRepositories(){

        //save a recipe in the repo and then check its there.
        Recipe recipe = new Recipe();
        recipe.setDirections("just add water");
        //u must block there is no subscriber so otherwise wont save.
        recipeReactiveRepository.save(recipe).block();

        assertEquals(Long.valueOf(1), recipeReactiveRepository.findAll().count().block());

    }
}
