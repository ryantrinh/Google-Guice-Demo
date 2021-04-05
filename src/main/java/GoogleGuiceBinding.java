import com.google.inject.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@BindingAnnotation @Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
@interface WinWord {}

public class GoogleGuiceBinding {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new SpellCheckerBindingModule());

        TextEditorBinding textEditorBinding = injector.getInstance(TextEditorBinding.class);

        textEditorBinding.makeSpellBinding();
    }
}

class TextEditorBinding{
    private SpellCheckerBinding spellCheckerBinding;


    @Inject
    public TextEditorBinding(@WinWord SpellCheckerBinding spellCheckerBinding) {
        this.spellCheckerBinding = spellCheckerBinding;
    }

    public void makeSpellBinding(){
        spellCheckerBinding.checkSpellingBinding();
    }
}

class SpellCheckerBindingModule extends AbstractModule{
    @Override
    protected void configure() {
//        bind(SpellCheckerBinding.class).to(SpellCheckerBindingImp.class);
        bind(SpellCheckerBinding.class).annotatedWith(WinWord.class).to(WindWordCheckerBindingImp.class);
    }
}

interface SpellCheckerBinding{
    void checkSpellingBinding();
}

class SpellCheckerBindingImp implements SpellCheckerBinding{
    @Override
    public void checkSpellingBinding() {
        System.out.println("Inside SpellCheckerBinding.");
    }
}

class WindWordCheckerBindingImp extends SpellCheckerBindingImp {

    @Override
    public void checkSpellingBinding() {
        System.out.println("Inside WindWordCheckerBinding.");
    }
}


