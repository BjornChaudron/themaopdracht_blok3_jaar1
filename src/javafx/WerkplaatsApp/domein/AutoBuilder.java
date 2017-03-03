package javafx.WerkplaatsApp.domein;

public class AutoBuilder {
    private String ken;
    private String chas;
    private String mk;
    private String mod;

    public AutoBuilder setKen(String ken) {
        this.ken = ken;
        return this;
    }

    public AutoBuilder setChas(String chas) {
        this.chas = chas;
        return this;
    }

    public AutoBuilder setMk(String mk) {
        this.mk = mk;
        return this;
    }

    public AutoBuilder setMod(String mod) {
        this.mod = mod;
        return this;
    }

    public Auto createAuto() {
        return new Auto(ken, chas, mk, mod);
    }
}