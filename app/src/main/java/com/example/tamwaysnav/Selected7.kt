package com.example.tamwaysnav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Selected7 : AppCompatActivity(), UsersAdapter.ClickListener {

    private lateinit var rvUsers: RecyclerView
    private lateinit var usersAdapter7: UsersAdapter;
    private lateinit var toolbar: Toolbar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected7)
        initData();
    }

    private fun initData(){
        rvUsers = findViewById(R.id.rvUsers)
        toolbar = findViewById(R.id.tbtoolbar)
        this.setSupportActionBar(toolbar)
        this.supportActionBar!!.title = ""
        initRecyclerView();
    }

    private fun initRecyclerView(){
        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        usersAdapter7 = UsersAdapter(this);
        rvUsers.adapter = usersAdapter7;
        showData();


    }

    private fun populateUsers():List<UserModel>{

        var userList = ArrayList<UserModel>()
        userList.add(UserModel("NB Gate"))
        userList.add(UserModel("NB Canteen"))
        userList.add(UserModel("ABB Canteen"))
        userList.add(UserModel("PAV"))
        userList.add(UserModel("NB Finance"))
        userList.add(UserModel("NB Registrar"))
        userList.add(UserModel("NB OGLH"))
        userList.add(UserModel("NB SHS Faculty Room"))
        userList.add(UserModel("NB Bio Chemistry Laboratory"))
        userList.add(UserModel("NB 1st Floor (Room 101 - 103)"))
        userList.add(UserModel("NB 2nd Floor (Room 201 - 207)"))
        userList.add(UserModel("NB 3rd Floor (Room 301 - 309)"))
        userList.add(UserModel("NB 4th Floor (Room 401 - 409)"))
        userList.add(UserModel("NB 6th Floor (Room 601 - 610)"))
        userList.add(UserModel("NB 7th Floor (Room 701 - 709)"))
        userList.add(UserModel("ABB 1st Floor"))
        userList.add(UserModel("ABB 2nd Floor (Room 201 - 208)"))
        userList.add(UserModel("ABB 3rd Floor (Room 301 - 307)"))
        userList.add(UserModel("ABB 4th Floor (Room 401 - 407)"))
        userList.add(UserModel("ABB 5th Floor (Room 501 - 507)"))
        userList.add(UserModel("ABB 6th Floor (Room 601 - 607)"))


        return userList;
    }

    private fun showData(){
        usersAdapter7.setData(populateUsers())
    }

    override fun clickedItem(userModel: UserModel) {
        Log.e("TAG", userModel.username);

        when(userModel.username){
            "NB Gate"->
                startActivity(Intent(this@Selected7, Selected7to1k::class.java))
            "NB Finance"->
                startActivity(Intent(this@Selected7, Selected7to2e::class.java))
            "NB Registrar"->
                startActivity(Intent(this@Selected7, Selected7to2i::class.java))
            "NB OGLH"->
                startActivity(Intent(this@Selected7, Selected7to4e::class.java))
            "NB SHS Faculty Room"->
                startActivity(Intent(this@Selected7, Selected7to2m::class.java))
            "NB Bio Chemistry Laboratory"->
                startActivity(Intent(this@Selected7, Selected7to4c::class.java))
            "ABB Canteen"->
                startActivity(Intent(this@Selected7, Selected7tob1g::class.java))
            "NB Canteen"->
                startActivity(Intent(this@Selected7, Selected7to1f::class.java))
            "NB 1st Floor (Room 101 - 103)"->
                startActivity(Intent(this@Selected7, Selected7to1a::class.java))
            "NB 2nd Floor (Room 201 - 207)"->
                startActivity(Intent(this@Selected7, Selected7to2a::class.java))
            "NB 3rd Floor (Room 301 - 309)"->
                startActivity(Intent(this@Selected7, Selected7to3a::class.java))
            "NB 4th Floor (Room 401 - 409)"->
                startActivity(Intent(this@Selected7, Selected7to4a::class.java))
            "NB 6th Floor (Room 601 - 610)"->
                startActivity(Intent(this@Selected7, Selected7to6a::class.java))
            "NB 7th Floor (Room 701 - 709)"->
                startActivity(Intent(this@Selected7, Selected7to7a::class.java))
            "ABB 1st Floor"->
                startActivity(Intent(this@Selected7, Selected7tob1a::class.java))
            "ABB 2nd Floor (Room 201 - 208)"->
                startActivity(Intent(this@Selected7, Selected7tob2a::class.java))
            "ABB 3rd Floor (Room 301 - 307)"->
                startActivity(Intent(this@Selected7, Selected7tob3a::class.java))
            "ABB 4th Floor (Room 401 - 407)"->
                startActivity(Intent(this@Selected7, Selected7tob4a::class.java))
            "ABB 5th Floor (Room 501 - 507)"->
                startActivity(Intent(this@Selected7, Selected7tob5a::class.java))
            "ABB 6th Floor (Room 601 - 607)"->
                startActivity(Intent(this@Selected7, Selected7tob6a::class.java))



            else -> {
                Toast.makeText(this,"Wala pa", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu,menu)
        var menuItem = menu!!.findItem(R.id.searchView)
        var searchView: SearchView = menuItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                usersAdapter7.filter.filter(newText)
                return true;
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}

