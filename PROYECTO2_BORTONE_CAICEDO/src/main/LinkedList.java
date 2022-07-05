/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author giubo
 */
public class LinkedList<T> {

    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public LinkedList() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * @return the pFirst
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    //PRIMITIVAS
    public boolean isEmpty() {
        return pFirst == null;
    }

    public void InitialInsert(T data) {
        Nodo<T> nuevo = new Nodo(data);
        if (isEmpty()) {
            pFirst = nuevo;
            pLast = nuevo;
        } else {
            Nodo aux = pFirst;
            nuevo.setPnext(aux);
            pFirst = nuevo;
        }
        size += 1;

    }

    public void InitialInsertNodo(Nodo nodito) {
        if (isEmpty()) {
            pFirst = nodito;
            pLast = nodito;
        } else {
            Nodo aux = pFirst;
            nodito.setPnext(aux);
            pFirst = nodito;
        }
        size += 1;

    }

    public void InsertForIndex(T data, int pos) {
        Nodo<T> nuevo = new Nodo(data);
        Nodo aux = pFirst;

        if (pos == 1 || isEmpty()) {
            this.InitialInsert(data);

        } else if (pos == size + 1) {
            this.FinalInsert(data);

        } else if (pos > size + 1) {
            System.out.println("Posicion no valida");

        } else {
            if (SearchGetValue(pos) != null) {
                this.DeleteForIndex(pos);
            }
            for (int i = 0; i < size; i++) {
                if (getPosicion(aux.getPnext()) == pos) {
                    nuevo.setPnext(aux.getPnext());
                    aux.setPnext(nuevo);
                    break;

                } else {
                    aux = aux.getPnext();
                }
            }
            size++;

        }
    }

    public int getPosicion(Nodo nodito) {
        if (!isEmpty()) {
            Nodo aux = pFirst;
            int contador = 1;
            while (aux != nodito) {
                contador++;
                aux = aux.getPnext();
            }
            return contador;
        } else {
            return -1;
        }
    }

    public Nodo getNodo(int pos) {
        if (!isEmpty()) {
            if (pos == size) {
                return pLast;
            } else if (pos == 1) {
                return pFirst;
            } else {
                Nodo aux = pFirst;
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getPnext();
                }
                return aux;
            }

        } else {
            return null;
        }
    }

    public T SearchGetValue(int pos) {
        if (!isEmpty() && pos <= size && pos > 0) {
            Nodo aux = pFirst;
            while (aux != null) {
                if (getPosicion(aux) == pos) {
                    return (T) aux.getDato();

                } else {
                    aux = aux.getPnext();
                }
            }
        } else {
            System.out.println("La lista esta vacia o la posicion no es valida");
        }
        return null;
    }

    public int SearchGetIndex(T valor) {
        boolean encontrado = false;
        int index = 0;
        if (!isEmpty()) {
            Nodo aux = pFirst;
            Nodo temp = pLast;
            if (aux.getDato() == valor && aux == pFirst) {
                encontrado = true;
                index = 1;

            } else if (temp.getDato() == valor) {
                encontrado = true;
                index = size;

            } else {
                for (int i = 0; i < size - 1; i++) {
                    if (aux.getDato() == valor) {
                        encontrado = true;
                        index = i + 1;
                        break;

                    } else {
                        aux = aux.getPnext();
                    }
                }
            }

        } else {
            System.out.println("La lista esta vacia");
            index = -1;

        }
        if (encontrado == false) {
            System.out.println("El numero no esta en la 9lista");
            index = -1;
        }
        return index;
    }

    public void FinalInsert(T data) {
        Nodo<T> nuevo = new Nodo(data);
        if (isEmpty()) {
            pFirst = nuevo;
            pLast = nuevo;
        } else {
            Nodo aux = pLast;
            aux.setPnext(nuevo);
            pLast = nuevo;
        }
        size += 1;

    }

    public void FinalInsertNodo(Nodo nodito) {
        if (isEmpty()) {
            pFirst = nodito;
            pLast = nodito;
        } else {
            Nodo aux = pLast;
            aux.setPnext(nodito);
            pLast = nodito;
        }
        size += 1;

    }

    public void print() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");

        } else {
            Nodo aux = pFirst;
            for (int i = 0; i < size; i++) {
                System.out.print(aux.getDato() + " ");
                aux = aux.getPnext();
            }
        }

    }

    public void DeleteInicio() {
        if (!isEmpty()) {
            if (size == 1) {
                pFirst = null;
                pLast = null;
                size = 0;
            } else {
                pFirst = pFirst.getPnext();
                size--;
            }

        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void DeleteFinal() {
        if (!isEmpty()) {
            Nodo aux = pFirst;
            if (size == 1) {
                pFirst = null;
                pLast = null;
                size = 0;
            } else {
                for (int i = 0; i < size; i++) {
                    if (aux.getPnext() == pLast) {
                        pLast = aux;
                        aux.setPnext(null);
                        size--;
                        break;
                    } else {
                        aux = aux.getPnext();
                    }
                }
            }

        } else {
            System.out.println("La lista esta vacia");

        }
    }

    public void DeleteValue(T data) {
        if (!isEmpty()) {
            boolean encontrado = false;
            Nodo aux = pFirst;
            if (pFirst.getDato() == data) {
                encontrado = true;
                this.DeleteInicio();
            } else if (pLast.getDato() == data) {
                encontrado = true;
                this.DeleteFinal();
            } else {
                for (int i = 0; i < size - 1; i++) {
                    if (aux.getPnext().getDato() == data) {
                        Nodo siguiente = aux.getPnext().getPnext();
                        aux.setPnext(siguiente);
                        encontrado = true;
                        size--;
                        break;
                    } else {
                        aux = aux.getPnext();
                    }
                }

            }
            if (encontrado == false) {
                System.out.println("El numero no esta en la lista");
            }
        } else {
            System.out.println("La lista esta vacia");

        }
    }

    public void DeleteForIndex(int pos) {
        boolean encontrado = false;
        Nodo aux = pFirst;
        if (!isEmpty()) {
            if (pos == 1) {
                encontrado = true;
                this.DeleteInicio();
            } else if (pos == size) {
                encontrado = true;
                this.DeleteFinal();
            } else {
                for (int i = 0; i < size - 1; i++) {
                    if (SearchGetIndex((T) aux.getPnext().getDato()) == pos) {
                        aux.setPnext(aux.getPnext().getPnext());
                        encontrado = true;
                        size--;
                        break;
                    } else {
                        aux = aux.getPnext();
                    }
                }
            }
        } else {
            System.out.println("La lista esta vacia");
        }
        if (encontrado == false) {
            System.out.println("Ingrese una posicion valida");
        }
    }

    public void SortMinorToMajor() {  //ordena de menor a mayor

        Nodo aux1 = pFirst;

        for (int i = 1; i < size; i++) {
            T dato1 = (T) aux1.getDato();
            Nodo aux2 = aux1.getPnext();
            while (aux2 != null) {
                T dato2 = (T) aux2.getDato();
                if ((int) dato1 > (int) dato2) {
                    IntercambiarNodoSegunNodo(aux1, aux2);
                    dato1 = (T) aux1.getDato();
                }
                aux2 = aux2.getPnext();
            }
            aux1 = aux1.getPnext();
        }
    }

    public void SortMajorToMinor() {

        Nodo aux1 = pFirst;

        for (int i = 1; i < size; i++) {
            T dato1 = (T) aux1.getDato();
            Nodo aux2 = aux1.getPnext();
            while (aux2 != null) {
                T dato2 = (T) aux2.getDato();
                if ((int) dato1 < (int) dato2) {
                    IntercambiarNodoSegunNodo(aux1, aux2);
                    dato1 = (T) aux1.getDato();
                }
                aux2 = aux2.getPnext();
            }
            aux1 = aux1.getPnext();
        }
    }

    public void BurbbleSort() {
        if (!isEmpty()) {
            Nodo actual = pFirst;
            Nodo temp;
            Nodo siguiente = actual.getPnext();
            for (int i = 0; i < size; i++) {
                if ((int) actual.getDato() > (int) siguiente.getDato()) {
                    temp = actual;
                    actual.setDato(siguiente);
                    siguiente.setDato(temp);
                    actual = actual.getPnext();

                } else {
                    actual = actual.getPnext();
                }

            }
        }
    }

    public void SortListMinorToMajor() {
        if (!this.isEmpty()) {
            Nodo aux = ExtraerNodo((T) BuscarMayor().getDato());
            SortListMinorToMajor();
            FinalInsertNodo(aux);

        }
    }

    public void SortListMajorToMinor() {
        if (!this.isEmpty()) {
            Nodo aux = ExtraerNodo((T) BuscarMayor().getDato());
            SortListMajorToMinor();
            InitialInsertNodo(aux);

        }
    }

    public Nodo ExtraerNodo(T value) {
        Nodo aux = pFirst;
        Nodo aux2 = pLast;
        Nodo nodito = null;
        if (!isEmpty()) {
            if (aux.getDato() == value) {
                nodito = pFirst;
                this.DeleteInicio();
            } else if (aux2.getDato() == value) {
                nodito = pLast;
                this.DeleteFinal();
            } else {
                for (int i = 0; i < size - 1; i++) {
                    if (aux.getDato() == value) {
                        nodito = aux;
                        this.DeleteForIndex(getPosicion(aux));
                        break;
                    } else {
                        aux = aux.getPnext();
                    }
                }
            }
        } else {
            System.out.println("La lista esta vacia");
        }
        return nodito;
    }

    public Nodo BuscarMayor() {
        Nodo aux1 = pFirst;
        Nodo mayor = pFirst;
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if ((int) aux1.getDato() > (int) mayor.getDato()) {
                    mayor = aux1;
                }
                aux1 = aux1.getPnext();
            }
        } else {
            System.out.println("La lista esta vacia");

        }

        return mayor;

    }

    public void IntercambiarNodoSegunNodo(Nodo a, Nodo b) {    //intercambia el cotenido de dos nodos, debemos pasarle los dos nodos a los que queremos intercambiar el contenido

        T dato = (T) a.getDato();
        a.setDato(b.getDato());
        b.setDato(dato);
    }

    public void IntercambiarNodoSegunIndice(int a, int b) {    //intercambia el contenido de dos nos dado el indice de estos dentro de la lista

        Nodo auxiliar1 = getNodo(a);
        Nodo auxiliar2 = getNodo(b);

        T dato = (T) auxiliar1.getDato();
        auxiliar1.setDato(auxiliar2.getDato());
        auxiliar2.setDato(dato);
    }

}
