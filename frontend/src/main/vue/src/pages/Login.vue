<template>

  <div class="content">
    <div class="container-fluid col-md-3">
      <card>
        <h4 slot="header" class="card-title" style="text-align: center">Login</h4>
        <form>
          <div class="row">

            <div class="col-sm">
              <base-input type="text"

                          placeholder="Username"
                          v-model="user.username">
              </base-input>
            </div>
          </div>

          <div class="row">
            <div class="col-sm">
              <base-input type="password"

                          placeholder="Password"
                          v-model="user.password">
              </base-input>
            </div>
          </div>

          <div class="row">
            <div class="col-sm">
              <button type="submit" class="btn btn-info btn-fill"
                      style="width: 100%"
                      @click.prevent="loginSubmit">
                Login
              </button>
            </div>
          </div>

        </form>
      </card>
    </div>
  </div>

</template>

<script>

  import Card from 'src/components/Cards/Card.vue'

  export default {
    components: {
      Card
    },
    data() {
      return {
        user: {},
        msg: proxyObj.accessToken
      }
    },
    methods: {
      loginSubmit() {
        alert('Your data: ' + JSON.stringify(this.user))
      }
    }
  };

</script>
<style>

</style>
