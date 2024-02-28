<template>
  <router-view v-slot="slotProps">
    <transition name="fade-button" mode="out-in">
      <component :is="slotProps.Component"></component>
    </transition>
  </router-view>
  <!--  <div class="container">
      <UsersLIst></UsersLIst>
    </div>
    <div class="container">
      <div class="block" :class="{animate: animateBlock}"></div>
      <button @click="changeAnimateBlock">Animate</button>
    </div>
    <div class="container">
      <transition :css="false"
                  @beforeEnter="beforeEnter" @enter="enter" @afterEnter="afterEnter"
                  @beforeLeave="beforeLeave" @leave="leave" @afterLeave="afterLeave"
                  @enterCancelled="enterCancelled" @leaveCancelled="leaveCancelled"
      >
        <p v-if="paraIsVisible">This is only sometimes visible...</p>
      </transition>
      <button @click="toggleParagraph">Toggle Paragraph</button>
    </div>
    <div class="container">
      <transition name="fade-button" mode="out-in">
        <button @click="showUsers" v-if="!usersAreVisible">Show Users</button>
        <button @click="hideUsers" v-else>Hide Users</button>
      </transition>
    </div>
    <BaseModal @close="hideDialog" :open="dialogIsVisible">
      <p>This is a test dialog!</p>
      <button @click="hideDialog">Close it!</button>
    </BaseModal>
    <div class="container">
      <button @click="showDialog">Show Dialog</button>
    </div>-->
</template>

<script setup>
import {ref} from "vue";
import UsersLIst from "@/components/UsersLIst.vue";

const dialogIsVisible = ref(false);
const animateBlock = ref(false);
const paraIsVisible = ref(false);
const usersAreVisible = ref(false);
const enterInterval = ref(null);
const leaveInterval = ref(null);
const showUsers = () => usersAreVisible.value = true;
const hideUsers = () => usersAreVisible.value = false;
const showDialog = () => dialogIsVisible.value = true;
const hideDialog = () => dialogIsVisible.value = false;
const changeAnimateBlock = () => animateBlock.value = true;
const toggleParagraph = () => paraIsVisible.value = !paraIsVisible.value;
const beforeEnter = (el) => {
  console.log('beforeEnter = ', el);
  el.style.opacity = 0;
}
const enter = (el, done) => {
  console.log('enter = ', el);
  let round = 1;
  enterInterval.value = setInterval(() => {
    el.style.opacity = round * 0.01;
    round++;
    if (round > 100) {
      clearInterval(enterInterval.value)
      done();
    }
  }, 20);
}
const afterEnter = (el) => {
  console.log('afterEnter = ', el);
}
const beforeLeave = (el) => {
  console.log('beforeLeave = ', el);
  el.style.opacity = 1;
}
const leave = (el, done) => {
  console.log('leave = ', el);
  let round = 1;
  leaveInterval.value = setInterval(() => {
    el.style.opacity = 1 - round * 0.01;
    round++;
    if (round > 100) {
      clearInterval(leaveInterval.value)
      done();
    }
  }, 20);
}
const afterLeave = (el) => {
  console.log('afterLeave = ', el);
}
const enterCancelled = (el) => {
  console.log('enterCancelled = ', el);
  clearInterval(enterInterval.value);
}
const leaveCancelled = (el) => {
  console.log('leaveCancelled = ', el);
  clearInterval(leaveInterval.value);
}

</script>

<style>
* {
  box-sizing: border-box;
}

html {
  font-family: sans-serif;
}

body {
  margin: 0;
}

button {
  font: inherit;
  padding: 0.5rem 2rem;
  border: 1px solid #810032;
  border-radius: 30px;
  background-color: #810032;
  color: white;
  cursor: pointer;
}

button:hover,
button:active {
  background-color: #a80b48;
  border-color: #a80b48;
}

.block {
  width: 8rem;
  height: 8rem;
  background-color: #290033;
  margin-bottom: 2rem;
  /*transition: transform 0.3s ease-out;*/
}

.container {
  max-width: 40rem;
  margin: 2rem auto;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 2rem;
  border: 2px solid #ccc;
  border-radius: 12px;
}

.animate {
  /*transform: translateX(-150px);*/
  animation: slide-fade 0.3s ease-out forwards;
}

/*

.para-enter-from {
  !*opacity: 0;
  transform: translateY(-30px);*!
}

.para-enter-active {
  !*transition: all 0.3s ease-out;*!
  animation: slide-scale 0.3s ease-out;
}

.para-enter-to {
  !*opacity: 1;
  transform: translateY(0);*!
}

.para-leave-from {
  !*opacity: 1;
  transform: translateY(0);*!
}

.para-leave-active {
  !*transition: all 0.3s ease-in;*!
  animation: slide-scale 0.3s ease-out;
}

.para-leave-to {
  !*opacity: 0;
  transform: translateY(30px);*!
}
*/

.fade-button-enter-from,
.fade-button-leave-to {
  opacity: 0;
}

.fade-button-enter-active {
  transition: opacity 0.3s ease-out;
}

.fade-button-leave-active {
  transition: opacity 0.3s ease-in;
}

.fade-button-enter-to,
.fade-button-leave-from {
  opacity: 1;
}

.router-enter-from {
}

.router-enter-active {
  animation: slide-scale 0.4s ease-out;
}

.router-enter-to {
}

.router-leave-from {
}

.router-leave-active {
  animation: slide-scale 0.4s ease-in;
}

.router-leave-to {
}

@keyframes slide-fade {
  0% {
    transform: translateX(0) scale(1);
  }

  70% {
    transform: translateX(-120px) scale(1.1);
  }

  100% {
    transform: translateX(-150px) scale(1);
  }
}

@keyframes slide-scale {
  0% {
    transform: translateX(0) scale(1);
  }

  70% {
    transform: translateX(-120px) scale(1.1);
  }

  100% {
    transform: translateX(-150px) scale(1);
  }
}
</style>