import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {$} from 'protractor';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.scss']
})
export class ShoppingListComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    /*const myNodelist = document.getElementsByTagName('LI');
    const i;
    for (i = 0; i < myNodelist.length; i++) {
      const span = document.createElement('SPAN');
      const txt = document.createTextNode('\u00D7');
      span.className = 'close';
      span.appendChild(txt);
      myNodelist[i].appendChild(span);
    }

// Click on a close button to hide the current list item
    const close = document.getElementsByClassName('close');
    const i;
    for (i = 0; i < close.length; i++) {
      close[i].onclick = function() {
        const div = this.parentElement;
        div.style.display = 'none';
      };
    }

// Add a "checked" symbol when clicking on a list item
    const list = document.querySelector('ul');
    list.addEventListener('click', function(ev) {
      if (ev.target.tagName === 'LI') {
        ev.target.classList.toggle('checked');
      }
    }, false);
  }

  // Create a new list item when clicking on the "Add" button
  newElement() {
    const li = document.createElement('li');
    const inputValue = document.getElementById('myInput').value;
    const t = document.createTextNode(inputValue);
    li.appendChild(t);
    if (inputValue === '') {
      alert('You must write something!');
    } else {
      document.getElementById('myUL').appendChild(li);
    }
    document.getElementById('myInput').value = '';

    const span = document.createElement('SPAN');
    const txt = document.createTextNode('\u00D7');
    span.className = 'close';
    span.appendChild(txt);
    li.appendChild(span);

    for (i = 0; i < close.length; i++) {
      close[i].onclick = function() {
        const div = this.parentElement;
        div.style.display = 'none';
      };
    }*/
  }






}
