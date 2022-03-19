//mobile view
function toggle_navbar() {
    console.log("mobile view is ready");
    let x = document.getElementById("nav_mobile");
    if (x.className === "topnav") {
      x.className += " responsive";
    } else {
      x.className = "topnav";
    }
}

