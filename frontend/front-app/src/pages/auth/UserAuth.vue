<template>
  <div>
    <BaseDialog :show="!!error" title="An error occurred" @close="dialogHandleError">
      <p>{{ error }}</p>
    </BaseDialog>
    <BaseDialog :show="isLoading" title="Authenticating..." fixed>
      <p>Authenticating...</p>
      <BaseSpinner></BaseSpinner>
    </BaseDialog>
    <BaseCard>
      <form @submit.prevent="submitForm">
        <div class="form-control">
          <label for="email">E-Mail</label>
          <input type="text" name="email" id="email" v-model.trim="email">
        </div>
        <div class="form-control">
          <label for="password">Password</label>
          <input type="password" name="password" id="password" v-model.trim="password">
        </div>
        <p v-if="!formIsValid">Please enter a valid email and password (must be at least 6 characters long).</p>
        <BaseButton>{{ submitButtonCaption }}</BaseButton>
        <BaseButton type="button" mode="flat" @click="switchAuthMode">{{ switchModeButtonCaption }}</BaseButton>
      </form>
    </BaseCard>
  </div>
</template>

<script setup>
import {computed, ref} from 'vue';
import {useAuthStore} from '@/stores/auth/index.js';
import {useRoute, useRouter} from "vue-router";

const authStore = useAuthStore();
const router = useRouter();
const route = useRoute();

const email = ref('');
const password = ref('');
const formIsValid = ref(true);
const mode = ref('login');
const isLoading = ref(false);
const error = ref(null);

const submitForm = async () => {
  formIsValid.value = true;
  if (email.value === '' || !email.value.includes('@') || password.value.length < 6) {
    formIsValid.value = false;
    return;
  }

  isLoading.value = true;

  const actionPayload = {
    email: email.value,
    password: password.value
  };

  try {
    if (mode.value === 'login') {
      await authStore.login(actionPayload).then(() => {
        const redirectUrl = `/${route.query.redirect || 'coaches'}`;
        router.replace(redirectUrl);
      });
    } else {
      await authStore.signup(actionPayload);
    }
  } catch (err) {
    error.value = err.message || 'Failed to authenticate, try later.';
  }

  isLoading.value = false;
};
const switchAuthMode = () => {
  if (mode.value === 'login') {
    mode.value = 'signup';
  } else {
    mode.value = 'login';
  }
};

const submitButtonCaption = computed(() => {
  if (mode.value === 'login') {
    return 'Login';
  } else {
    return 'Signup';
  }
})

const switchModeButtonCaption = computed(() => {
  if (mode.value === 'login') {
    return 'Signup instead';
  } else {
    return 'Login instead';
  }
})

const dialogHandleError = () => {
  error.value = null;
}
</script>

<style scoped>
form {
  margin: 1rem;
  padding: 1rem;
}

.form-control {
  margin: 0.5rem 0;
}

label {
  font-weight: bold;
  margin-bottom: 0.5rem;
  display: block;
}

input,
textarea {
  display: block;
  width: 100%;
  font: inherit;
  border: 1px solid #ccc;
  padding: 0.15rem;
}

input:focus,
textarea:focus {
  border-color: #3d008d;
  background-color: #faf6ff;
  outline: none;
}
</style>