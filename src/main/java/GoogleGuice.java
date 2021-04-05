import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


class GoogleGuice {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new TextEditorModule());
        TextEditor textEditor = injector.getInstance(TextEditor.class);
        textEditor.makeSpellCheck();

    }
}

class TextEditor {
    private SpellChecker spellChecker;

    @Inject
    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void makeSpellCheck() {
        spellChecker.checkSpelling();
    }
}

//Biding module
class TextEditorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SpellChecker.class).to(SpellCheckerImp.class);
        bind(SpellCheckerImp.class).to(WinWordSpellCheckerImp.class);
    }
}

interface SpellChecker {
     void checkSpelling();
}

class SpellCheckerImp implements SpellChecker {

    @Override
    public void checkSpelling() {
        System.out.println("Inside checkSpelling...");
    }
}

    class WinWordSpellCheckerImp extends SpellCheckerImp{
        @Override
        public void checkSpelling() {
            System.out.println("Inside WinWordSpellCheckerImpl.checkSpelling.");
        }
    }

