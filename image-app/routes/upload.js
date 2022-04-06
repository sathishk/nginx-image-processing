// Importing the required modules
var express = require('express');
var bodyparser = require('body-parser');
var fs = require('fs');
var multer = require('multer');
var sharp = require('sharp');
  
var upload = multer({dest : './images'}) 
  
var router = express.Router();  
  
// Use body-parser to parse incoming data
router.use(bodyparser.urlencoded({extended : true}))     
  
// Use the upload middleware containing 
// our file configuration, with the name
// of input file attribute as "avatar"
// to the desired configuration.
  
router.post('/', upload.single("avatar"), (req, res)=>
{
    console.log(req.file.originalname);
    fs.rename(req.file.path, './public/images/'+req.file.originalname, (err)=>{
        console.log(err);
    })

    sharp('./public/images/'+req.file.originalname).resize(200,200)
    .jpeg({quality : 50}).toFile('./public/images/thumbnail/'+req.file.originalname);
  
  
    sharp('./public/images/'+req.file.originalname).resize(640,480)
    .jpeg({quality : 80}).toFile('./public/images/preview/'+req.file.originalname);
  
    return res.json("File Uploaded Successfully!");
});

module.exports = router;