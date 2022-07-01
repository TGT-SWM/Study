//
//  LandmarksApp.swift
//  Landmarks
//
//  Created by 최정인 on 2022/06/22.
//

import SwiftUI

@main
struct LandmarksApp: App {
    @StateObject private var modelData = ModelData()
    
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(modelData)
        }
    }
}
