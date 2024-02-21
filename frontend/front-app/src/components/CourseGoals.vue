<template>
  <ul>
    <li v-for="goal in goals" :key="goal">
      <slot :item="goal" anotherProp="..."></slot>
    </li>
  </ul>
</template>

<script setup>
import {ref} from "vue";

const goals = ref(['Finish the course', 'Learn Vue']);
</script>

<style scoped>

</style>