# EBNF Support IDEA Plugin
This plugin adds IDE support for custom EBNF-like language for description of formal grammars.
Lexer and parser are created with [Grammar-Kit](https://github.com/JetBrains/Grammar-Kit),
grammar for EBNF language cna be found in [Ebnf.bnf](src/main/kotlin/com/das747/ebnfplugin/lang/Ebnf.bnf).
### Supported features:
- Syntax highlighting
- Completion suggestions
- Structure view
- Navigation to source
- Formatting
- Inspections

### Implemented inspections:
- Unused rules
- Undefined non-terminals
- Multiple rule declarations
- Equivalent variants in alternative
- Redundant grouping
- Alternative push-down

## Running 
To run plugin inside development instance of Intellij IDEA, execute
```bash
./gradlew runIde
```
Alternatively, you can download prebuilt plugin from release and [install](https://www.jetbrains.com/help/idea/managing-plugins.html#install_plugin_from_disk) it in your IDE.