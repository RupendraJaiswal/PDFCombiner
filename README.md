
# 📎 PDF Combiner - Java (Swing + PDFBox)

A simple Java desktop application to combine multiple PDF files into a single PDF using [Apache PDFBox](https://pdfbox.apache.org/). The application allows you to dynamically select a folder containing PDFs and choose the destination for the merged output using a Swing-based GUI.

---

## ✨ Features

- 📂 Dynamically select a folder containing multiple PDF files
- 📁 Choose output file location and name
- ⚡ Fast merging using Apache PDFBox
- 🧾 Simple and user-friendly GUI built with Swing

---

## 🛠 Tech Stack

- Java 8+
- Maven
- [Apache PDFBox (v2.0.29)](https://pdfbox.apache.org/)
- Swing (for GUI)

---

## 🚀 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/RupendraJaiswal/PDFCombiner.git
   cd PDFCombiner
   ```

2. **Build the project**
   ```bash
   mvn compile
   ```

3. **Run the application**
   ```bash
   mvn exec:java -Dexec.mainClass="com.pdfCombiner.main.PdfMerger"
   ```

> ⚠️ If you encounter an error while running, add the following to your `pom.xml` inside the `<build>` section:
> 
> ```xml
> <plugins>
>   <plugin>
>     <groupId>org.codehaus.mojo</groupId>
>     <artifactId>exec-maven-plugin</artifactId>
>     <version>3.1.0</version>
>   </plugin>
> </plugins>
> ```

---

## 📁 Folder Structure

```text
PDFCombiner/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── pdfCombiner/
        │           └── main/
        │               └── PdfMerger.java
        └── resources/
```

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Author

Made with ❤️ by [Rupendra Jaiswal](https://github.com/RupendraJaiswal)
