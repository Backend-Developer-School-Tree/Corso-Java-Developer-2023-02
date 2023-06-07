# File explorer ricorsivo 🛵📁

Si realizzi una classe Cartella, costruita a partire dal percorso di una cartella reale,
dotata di un metodo `toString()` che ne visualizzi ricorsivamente il contenuto.

Esempio di possibile visualizzazione della cartella [test_folder](test_folder):
```
| test_folder
|-- folder1
|-- |-- file
|-- folder2
|-- |-- folder1
|-- |-- |-- file1
|-- |-- |-- file2
|-- |-- |-- file3
|-- |-- file1
|-- file1
|-- file2
```

Realizzare inoltre i seguenti metodi ricorsivi:
- Cerca un file all’interno di una cartella
- Cerca all'nterno della cartella tutti i file con l'estensione specificata
- Cerca all'interno della cartella tutti i file con le estensioni fornite in input

N.B. si faccia uso al meglio dell'overloading
