//
//  ViewController.swift
//  bible_memo_ios
//
//  Created by yubert on 2016/05/06.
//  Copyright © 2016年 yubert. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func onClickButton(sender: UIButton) {
        
        // create the url-request
        let myConfig:NSURLSessionConfiguration = NSURLSessionConfiguration.backgroundSessionConfigurationWithIdentifier("backgroundTask")
        
        let mySession:NSURLSession = NSURLSession(configuration: myConfig)
        let urlString = "http://157.7.136.138/update_db.php"
        let request = NSMutableURLRequest(URL: NSURL(string: urlString)!)
        request.HTTPMethod = "POST"
        let params = "place=place_ios"
        let myData = params.dataUsingEncoding(NSUTF8StringEncoding)!
        request.HTTPBody = myData
        let myTask = mySession.dataTaskWithRequest(request)
        myTask.resume()
        
        print("完了")
        print(request)
    }

}

