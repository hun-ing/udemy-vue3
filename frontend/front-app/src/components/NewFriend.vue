<template>
  <form @submit.prevent="submitData">
    <div>
      <label>이름</label>
      <input type="text" v-model="enteredName"/>
    </div>
    <div>
      <label>휴대폰</label>
      <input type="tel" v-model="enteredPhone"/>
    </div>
    <div>
      <label>이메일</label>
      <input type="email" v-model="enteredEmail"/>
    </div>
    <div>
      <button>추가</button>
    </div>
  </form>
</template>

<script setup>
import {ref} from "vue";

const emits = defineEmits(['add-contact']);

const enteredName = ref('');
const enteredPhone = ref('');
const enteredEmail = ref('');
const submitData = () => emits('add-contact', enteredName.value, enteredPhone.value, enteredEmail.value);
</script>

<style scoped>

</style>