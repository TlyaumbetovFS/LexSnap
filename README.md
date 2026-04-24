# LexSnap

A web application for saving and translating unknown words. Enter a word, get an instant translation powered by `LibreTranslate`.

## Run

```bash
docker run -d --name libretranslate -p 5000:5000 libretranslate/libretranslate
mvn spring-boot:run
```