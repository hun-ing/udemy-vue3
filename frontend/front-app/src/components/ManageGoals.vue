<template>
  <h2>Manage Goals</h2>
  <input type="text" ref="goal">
  <button @click="setGoal">Set Goal</button>
  <teleport to="body">
    <ErrorAlert v-if="inputIsInvalid">
      <h2>Input is invalid!</h2>
      <p>Please enter at least a few characters...</p>
      <button @click="confirmError">Okay</button>
    </ErrorAlert>
  </teleport>
</template>

<script setup>
import {ref} from "vue";
import ErrorAlert from "@/components/common/ErrorAlert.vue";

const goal = ref();
const inputIsInvalid = ref(false);
const setGoal = () => {
  const enteredValue = goal.value.value;
  if (enteredValue === '') {
    inputIsInvalid.value = true;
  }
}

const confirmError = () => {
  inputIsInvalid.value = false;
}
</script>

<style scoped>

</style>