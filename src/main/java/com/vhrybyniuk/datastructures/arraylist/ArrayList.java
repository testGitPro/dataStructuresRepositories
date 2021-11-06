package com.vhrybyniuk.datastructures.arraylist;

import com.vhrybyniuk.datastructures.interfaces.List;

public class ArrayList implements List {
        private int size;
        private Object[] arr;


        public ArrayList() {
            this.arr = new Object[10];
        }


        public ArrayList(int initCapacity) {
            arr = new Object[initCapacity];
        }

        private void assignCapacity() {
            if (arr.length == size) {
                Object[] newArray = new Object[arr.length * 2];
                for (int i = 0; i < arr.length; i++) {
                    newArray[i] = arr[i];
                }
                arr = newArray;

            }
        }

        @Override
        public void add(Object value) {

            assignCapacity();
            arr[size++] = value;
        }

        @Override
        public void add(Object value, int index) {

            if(index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index more than size" );
            }
            if(size >= arr.length) {
                assignCapacity();
            }
            for (int i = size; i > index; --i) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
            size++;
        }
        @Override
        public Object remove(int index) {
            int sizeForArr = size - 1;
            if(index > sizeForArr){
                throw new IndexOutOfBoundsException("Large Index for Array List");
            }
            Object object = get(index);
            for (int i = index; i < sizeForArr; i++) {
                this.set(get(i+1), i);
            }
            size--;
            return object;
        }

        @Override
        public Object get(int index) {
            if(index > size  - 1){
                throw new IndexOutOfBoundsException("Large Index for Array List");
            }
            return arr[index];
        }

        @Override
        public Object set(Object value, int index) {
            if(index > size){
                throw new IndexOutOfBoundsException("Large Index for Array List");
            }
            Object obj = arr[index];
            arr[index] = value;
            return obj;

        }

        @Override
        public void clear() {
            for (int i = 0; i < size; i++) {
                arr[i] = null;
            }
            size = 0;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean contains(Object value) {
            for (int i = 0; i < size; i++) {
                if(arr[i].equals(value)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public int indexOf(Object value) {
            for (int i = 0; i < size; i++) {
                if(arr[i].equals(value)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object value) {

            for (int i = size - 1; i >=0 ; i--) {
                if(arr[i].equals(value)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            int sizeForArr = size - 1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int i = 0; i < sizeForArr; i++) {
                stringBuilder.append(arr[i] + ",");
            }
            stringBuilder.append(arr[sizeForArr] + "]");
            return stringBuilder.toString();
        }
    }

