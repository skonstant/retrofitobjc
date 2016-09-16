//
//  ViewController.m
//  SPOTT
//
//  Created by Stephane Konstantaropoulos on 16/09/16.
//  Copyright © 2016 Stephane Konstantaropoulos. All rights reserved.
//

#import "ViewController.h"
#import "vol/Vol.h"
#import "vol/Repo.h"
#import "java/util/List.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    id<JavaUtilList> list = [[VolVol new] parse];
    for (int i = 0 ; i < 4; i++ ) {
    VolRepo * repo = [list getWithInt:0];
        NSLog(@"repo %@", repo->name_ );
    }
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
