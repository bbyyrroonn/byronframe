<template>
  <div id="app">
    <div>
      <login></login>
    </div>
  </div>
</template>

<script>
  import 'common/css/bootstrap.css';
  import 'common/css/font-awesome.css';
  import 'common/css/beyond.css';

  import 'common/css/reset.css';
  import Login from 'components/login/login';

  export default {
    name: 'app',
    components: {
      Login
    }
  }
</script>

<style>

</style>
