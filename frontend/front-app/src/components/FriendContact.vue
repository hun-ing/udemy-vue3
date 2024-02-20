<template>
  <li>
    <h2>{{ name }} {{ isFavorite ? '(Favorite)' : '' }}</h2>
    <button @click="toggleFavorite">Toggle Favorite</button>
    <button @click="toggleDetails">상세정보 {{ detailsAreVisible ? '닫기' : '열기' }}</button>
    <ul v-if="detailsAreVisible">
      <li><strong>휴대폰:</strong> {{ phoneNumber }}</li>
      <li><strong>이메일:</strong> {{ emailAddress }}</li>
    </ul>
  </li>
</template>

<script setup>
import {ref} from "vue";

const detailsAreVisible = ref(false);

// const props = defineProps(['name', 'phoneNumber', 'emailAddress', 'isFavorite']);
const props = defineProps({
  id: {
    type: String,
    required: true
  },
  name: {
    type: String,
    required: true
  },
  phoneNumber: {
    type: String,
    required: true
  },
  emailAddress: {
    type: String,
    required: true
  },
  isFavorite: {
    type: Boolean,
    required: false,
    default: false,
    // validator(value, props) {
    //   return value === '1' || value === '0';
    // }
  },
});
// const friendIsFavorite = ref(props.isFavorite);
const emits = defineEmits(['toggle-favorite']);
// const emits = defineEmits({
//   // No validation
//   click: null,
//
//   // Validate submit event
//   'toggle-favorite': (id) => {
//     if (id) {
//       return true;
//     } else {
//       console.warn('Id is missing!');
//       return false;
//     }
//   }
// });

const toggleFavorite = () => emits('toggle-favorite', props.id);
const toggleDetails = () => detailsAreVisible.value = !detailsAreVisible.value;
</script>

<style scoped>

</style>