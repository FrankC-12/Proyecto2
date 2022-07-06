/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author giubo
 */
public class Summary {
    
    private String tittle;
    private String autores[];
    private String cuerpo;
    private String[] key_words;

    public Summary(String titulo, String[] autores, String cuerpo, String[] key_words) {
        this.tittle = titulo;
        this.autores = autores;
        this.cuerpo = cuerpo;
        this.key_words = key_words;
    }

    /**
     * @return the tittle
     */
    public String getTittle() {
        return tittle;
    }

    /**
     * @param tittle the tittle to set
     */
    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    /**
     * @return the autores
     */
    public String[] getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    /**
     * @return the cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    /**
     * @return the key_words
     */
    public String[] getKey_words() {
        return key_words;
    }

    /**
     * @param key_words the key_words to set
     */
    public void setKey_words(String[] key_words) {
        this.key_words = key_words;
    }

    public int [] analizar() {
        int contador = 0;
        int cantidad = 0;
        int cantidad_key_words[] = new int[this.key_words.length];
        String resume[] = this.cuerpo.split("");
        for (String x : this.key_words) {
            System.out.println(x);
            for (String y : resume) {
                if (y.equals(x)) 
                    System.out.println("");{
                    cantidad++;
                   
                    cantidad_key_words[contador] = cantidad;
                 

                }

            }
            contador = contador + 1;
            cantidad = 0;
        }

        return cantidad_key_words;
    }
    
    
    public void search_for_autor (String autor ){
          HashTable<String, Summary> HashTableAutores = new HashTable();
          
          
          
    }
}

