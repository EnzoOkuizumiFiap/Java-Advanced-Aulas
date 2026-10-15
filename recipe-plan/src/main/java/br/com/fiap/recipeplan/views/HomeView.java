package br.com.fiap.recipeplan.views;

import br.com.fiap.recipeplan.model.Recipe;
import br.com.fiap.recipeplan.service.RecipeService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    private final VerticalLayout responsePanel = new VerticalLayout();
    private final RecipeService recipeService;

    public HomeView(RecipeService recipeService) {
        this.recipeService = recipeService;

        setSizeFull();
        setAlignItems(Alignment.CENTER);

        var input = new MessageInput();
        input.setWidthFull();

        // 4. View: adicione o tratamento do MessageInput para fazer a chamada para o service e mostrar o resultado no responsePanel
        input.addSubmitListener(event -> {
            String userInput = event.getValue().trim();
            if (!userInput.isEmpty()) {
                Recipe recipe = this.recipeService.getRecipe(userInput);
                showRecipe(recipe);
            }
        });

        add(new H1("Planejador de Receitas"));
        add(new Paragraph("O que você gostaria de cozinhar hoje?"));
        add(input);
        add(responsePanel);
    }

    private void showRecipe(Recipe recipe) {
        responsePanel.removeAll();
        if (recipe != null) {
            responsePanel.add(new RecipeView(recipe));
        }
    }
}