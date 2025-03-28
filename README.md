# 💡 Inyección de Dependencias: Interfaz vs Implementación

Este proyecto demuestra cómo Spring Boot maneja la inyección de dependencias cuando se definen beans por **interfaz** o por **implementación**.

---

## 📆 Estructura de Clases

### 1. Interfaz `Foo`

```java
public interface Foo {
    String getMessage();
}
```

---

### 2. Implementación `FooImplementation`

```java
@Component
public class FooImplementation implements Foo {
    public String getMessage() {
        return "Hello World";
    }
}
```

> ☕️ Spring registra esta clase como un bean con tipo `Foo` **y también** como `FooImplementation`.

---

### 3. Uso vía Interfaz - `FooUser`

```java
@Component
public class FooUser {
    @Autowired
    public FooUser(Foo foo) {
        this.foo = foo;
    }

    public void printMessage() {
        System.out.println("Injected Via Interface ====> " + foo.getMessage());
    }
}
```

---

### 4. Uso vía Implementación - `FooImplementationUser`

```java
@Component
public class FooImplementationUser {
    FooImplementationUser(FooImplementation fooImplementation) {
        this.fooImplementation = fooImplementation;
    }

    public void printMessage() {
        System.out.println("Injected via implementation ====> " + fooImplementation.getMessage());
    }
}
```

---

## ❓ ¿Qué pasa si se referencia con otro tipo?

Cuando se referencia un bean con un tipo distinto al que fue definido (por ejemplo, como `FooImplementation` en lugar de `Foo`):

- ✅ **No ocurre ningún error**: Spring detecta ambas formas.
- El bean `@Component FooImplementation` es registrado por Spring **con todas sus interfaces implementadas** y **su clase concreta**.
- Por lo tanto, puede inyectarse como `Foo` (interfaz) o como `FooImplementation` (clase), dependiendo de la firma del constructor.

> 🧐 Spring busca un bean del tipo requerido en el `ApplicationContext` y lo encuentra sin ambigüedad porque hay una sola implementación.

---

## 👨‍💻 Salida Esperada

```bash
Injected Via Interface ====> Hello World
Injected via implementation ====> Hello World
```

---

## ✅ Conclusión

- **Recomendación**: siempre que sea posible, inyectar usando interfaces para desacoplar el código y favorecer la prueba y escalabilidad.
- Spring permite inyectar por clase o interfaz, pero usar interfaces es una mejor práctica para seguir el principio de inversión de dependencias (D de SOLID).
