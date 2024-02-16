package com.wbs;

public class Urchin extends Pet {
    public Urchin(float posnX, float posnY, float size) throws Exception {
        super(TEXTURE_FILENAME, posnX, posnY, size);
        setTextureFilename("./textures/Urchin.png");
    }
}
